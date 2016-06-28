(ns ohce.core
  (:require
    [ohce.notifications :as notifications]))

(defn ohce
  ([hour-fn read-input name])

  ([select-greeting notifier read-input name]
    (notifications/greet notifier (select-greeting name))

    (let [input (read-input)]
      (when (not (clojure.string/blank? input))
        (notifications/echo notifier (apply str (reverse input)))))))