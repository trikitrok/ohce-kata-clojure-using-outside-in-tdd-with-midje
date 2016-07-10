(ns ohce.ohce
  (:require
    [ohce.notifications :as notifications]))

(defn- reverse-str [input]
  (apply str (reverse input)))

(defn- palindrome? [input]
  (= input (reverse-str input)))

(defn- should-stop? [input stop-word]
  (= input stop-word))

(defn- respond-to-input [notifier input]
  (notifications/echo notifier (reverse-str input))
  (when (palindrome? input)
    (notifications/palindromes-rock notifier)))

(defn- process-input [notifier input]
  (when-not (clojure.string/blank? input)
    (respond-to-input notifier input)))

(defn- interact-with-user [notifier read-input stop-word]
  (loop [input (read-input)]
    (when-not (should-stop? input stop-word)
      (do (process-input notifier input)
          (recur (read-input))))))

(defn ohce [select-greeting notifier read-input stop-word name]
  (notifications/greet notifier (select-greeting name))
  (interact-with-user notifier read-input stop-word)
  (notifications/bye-user notifier name))
