(ns ohce.day-period-greeter)

(defn select-greeting [hour-fn name]
  (hour-fn)
  (str "¡Buenos días " name "!"))