(ns get-primes.core)

(defn debug [msg]
  (fn [x] (println msg x)
  x))

(defn isPrime [n]
  ((debug "isPrime Outer") n)
  (reduce (fn [bool, m] (if (= (mod n m) 0) false true)) false (range 0 (js/Math.sqrt n))))

(defn getPrimes [start end]
  (reduce(fn [primeList, n] (-> n ((debug "main")) isPrime (#(if % (conj primeList n) primeList)) reverse)) () (range start end)))

(println (getPrimes 0 10))