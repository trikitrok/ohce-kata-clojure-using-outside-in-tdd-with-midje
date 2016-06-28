(ns ohce.test-helpers)

(defn output-lines [f & args]
  (clojure.string/split (with-out-str (apply f args)) #"\n"))
