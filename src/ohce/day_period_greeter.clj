(ns ohce.day-period-greeter)

(defn select-greeting [hour-fn name]
  (let [hour (hour-fn)]
    (if (and (<= 6 hour) (< hour 12))
      (str "¡Buenos días " name "!")
      (str "¡Buenas tardes " name "!"))))