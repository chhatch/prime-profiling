(ns get-primes.core ; ClojureScript namespace
  ;(:require [taoensso.tufte :as tufte :refer-macros (defnp p profiled profile)]))
)
;(tufte/add-basic-println-handler! {})

(defn isRelativePrime [n m]
  (not= (mod n m) 0))

(defn shouldContinue [m rootN]
  (< m rootN))

(defn isPrime [n]
  (let [rootN (int (Math/sqrt n))]
    (loop [m 2]
      (if (shouldContinue m rootN)
        (if (isRelativePrime n m)
          (recur (inc m))
          false)
        relativePrime))))

(defn getPrimes [start end]
    (loop [n start primeList ()]
        (if (> n end) primeList
          (recur (inc n) (if (isPrime n) (conj primeList n)
          primeList)))))

(time (println (count (getPrimes 2 1e6)) "primes found"))