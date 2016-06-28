(ns ohce.core
  (:require
    [ohce.notifications :refer [echo greet bye-user palindromes-rock]]))

(defn- reverse-str [input]
  (apply str (reverse input)))

(defn- palindrome? [input]
  (= input (reverse-str input)))

(defn should-stop? [input]
  (= input "Stop!"))

(defn- process-inputs [notifier read-input]
  (loop [input (read-input)]
    (when-not (should-stop? input)
      (when-not (clojure.string/blank? input)
        (do
          (echo notifier (reverse-str input))
          (when (palindrome? input)
            (palindromes-rock notifier))
          (recur (read-input)))))))

(defn ohce [select-greeting notifier read-input name]
  (greet notifier (select-greeting name))
  (process-inputs notifier read-input)
  (bye-user notifier name))