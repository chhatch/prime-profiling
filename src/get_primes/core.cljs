(ns get-primes.core ; ClojureScript namespace
  ;(:require [taoensso.tufte :as tufte :refer-macros (defnp p profiled profile)]))
)
;(tufte/add-basic-println-handler! {})

(defn isRelativePrime [n m]
  (not= (mod n m) 0))

(defn isPrime? [n]
  (reduce (defn fn [_ m]
    (if (isRelativePrime n m) true (reduced false)))
    true (range 2 (inc (int (Math/sqrt n))))))

(defn getPrimes [start end]
    (for [n (range start end) :when (isPrime? n)] n))

(time (println (count (getPrimes 2 1e6)) "primes found"))