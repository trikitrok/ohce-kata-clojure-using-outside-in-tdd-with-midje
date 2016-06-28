(ns ohce.day-period-greeter)

(defn select-greeting [hour-fn name]
  (let [hour (hour-fn)]
    (cond
      (and (<= 6 hour) (< hour 12))
      (str "¡Buenos días " name "!")

      (and (<= 12 hour) (< hour 20))
      (str "¡Buenas tardes " name "!")

      :else
      (str "¡Buenas noches " name "!"))))