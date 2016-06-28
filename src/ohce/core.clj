(ns ohce.core
  (:require
    [ohce.notifications :refer [echo greet bye-user palindromes-rock]]))

(defn- reverse-str [input]
  (apply str (reverse input)))

(defn- palindrome? [input]
  (= input (reverse-str input)))

(defn should-stop? [input]
  (= input "Stop!"))

(defn ohce
  ([hour-fn read-input name])

  ([select-greeting notifier read-input name]
   (greet notifier (select-greeting name))

   (loop [input (read-input)]
     (if (should-stop? input)
       (bye-user notifier name)
       (when (not (clojure.string/blank? input))
         (do
           (echo notifier (reverse-str input))
           (when (palindrome? input)
             (palindromes-rock notifier))
           (recur (read-input))))))))