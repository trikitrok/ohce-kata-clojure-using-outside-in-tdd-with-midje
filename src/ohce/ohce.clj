(ns ohce.ohce
  (:require
    [ohce.notifications :as notifications]))

(defn- reverse-str [input]
  (apply str (reverse input)))

(defn- palindrome? [input]
  (= input (reverse-str input)))

(defn- should-stop? [input stop-word]
  (= input stop-word))

(defn- process-inputs [notifier read-input stop-word]
  (loop [input (read-input)]
    (when-not (should-stop? input stop-word)
      (when-not (clojure.string/blank? input)
        (do
          (notifications/echo notifier (reverse-str input))
          (when (palindrome? input)
            (notifications/palindromes-rock notifier))
          (recur (read-input)))))))

(defn ohce [select-greeting notifier read-input stop-word name]
  (notifications/greet notifier (select-greeting name))
  (process-inputs notifier read-input stop-word)
  (notifications/bye-user notifier name))
