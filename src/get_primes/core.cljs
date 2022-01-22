(ns get-primes.core ; ClojureScript namespace
  (:require [taoensso.tufte :as tufte :refer-macros (defnp p profiled profile)]))

;; We'll request to send `profile` stats to `println`:
(tufte/add-basic-println-handler! {})

(defn isPrime [n] (let [rootN (Math/floor (Math/sqrt n))]
  (reduce (fn [bool, m]
    (if (= (mod n m) 0) (reduced false) true))
    true (range 2 rootN))))

(defn getPrimes [start end]
  (p ::prime-test
    (reduce (fn [primeList, n]
        (-> n isPrime (#(if % (conj primeList n) primeList))))
    () (range start end))))

(time (println (count (profile {} (getPrimes 2 1e6))) "primes found"))