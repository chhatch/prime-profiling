(ns get-primes.core ; ClojureScript namespace
  (:require [taoensso.tufte :as tufte :refer-macros (defnp p profiled profile)]))

;; We'll request to send `profile` stats to `println`:
(tufte/add-basic-println-handler! {})

(defn isPrime [n, rootN]
  (loop [m 2 relativePrime (not= (mod n 2) 0) continue (< 2 rootN)]
    (if continue
      (if relativePrime
        (recur (inc m) (not= (mod n (inc m)) 0) (< (inc m) rootN))
        false)
      relativePrime)))

(defn getPrimes [start end]
    (loop [n start primeList ()]
        (if (> n end) primeList
          (recur (inc n) (if (isPrime n (Math/floor (Math/sqrt n))) (conj primeList n)
          primeList)))))

(time (println (count (profile {} (getPrimes 2 1e4))) "primes found"))