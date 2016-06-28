(ns ohce.core
  (:require
    [ohce.notifications :as notifications]))

(defn- reverse-str [input]
  (apply str (reverse input)))

(defn- palindrome? [input]
  (= input (reverse-str input)))

(defn ohce
  ([hour-fn read-input name])

  ([select-greeting notifier read-input name]
   (notifications/greet notifier (select-greeting name))

   (loop [input (read-input)]
     (if (= input "Stop!")
       (notifications/bye-user notifier name)

       (when (not (clojure.string/blank? input))
         (do
           (notifications/echo notifier (reverse-str input))
           (when (palindrome? input)
             (notifications/palindromes-rock notifier))
           (recur (read-input))))
       )


     )


    ))