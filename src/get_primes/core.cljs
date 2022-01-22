(ns get-primes.core)

(defn isPrime [n]
(let [rootN (Math/floor (Math/sqrt n))]
(reduce (fn [bool, m] (if (= (mod n m) 0) (reduced false) true))
  true (range 2 rootN))))

(defn getPrimes [start end]
  (reduce (fn [primeList, n]
      (-> n isPrime (#(if % (conj primeList n) primeList))))
    () (range start end)))

(time (println (count (getPrimes 2 1e6)) "primes found"))