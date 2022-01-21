(ns get-primes.core)

(defn isPrime [n]
  (loop [n n m 2 max (js/Math.sqrt n)]
    (if (= (mod n m) 0) false
      (if (> m max) true (recur n (inc m) max)))))

(defn getPrimes [start end]
  (reduce (fn [primeList, n]
      (-> n isPrime (#(if % (conj primeList n) primeList)) reverse))
    () (range start end)))

(time (println (count (getPrimes 2 100000)) "primes found"))