(ns ohce.core
  (:require
    [ohce.notifications :as notifications]))

(defn ohce
  ([hour-fn read-input name])

  ([select-greeting notifier read-input name]
    (notifications/greet notifier (select-greeting name))
    ))