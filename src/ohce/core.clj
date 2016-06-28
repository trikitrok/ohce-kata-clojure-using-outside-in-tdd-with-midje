(ns ohce.core
  (:require
    [ohce.notifications :refer [echo greet bye-user palindromes-rock]]))

(defn- reverse-str [input]
  (apply str (reverse input)))

(defn- palindrome? [input]
  (= input (reverse-str input)))

(defn should-stop? [input stop-word]
  (= input stop-word))

(defn- process-inputs [notifier read-input stop-word]
  (loop [input (read-input)]
    (when-not (should-stop? input stop-word)
      (when-not (clojure.string/blank? input)
        (do
          (echo notifier (reverse-str input))
          (when (palindrome? input)
            (palindromes-rock notifier))
          (recur (read-input)))))))

(defn ohce [select-greeting notifier read-input stop-word name]
  (greet notifier (select-greeting name))
  (process-inputs notifier read-input stop-word)
  (bye-user notifier name))