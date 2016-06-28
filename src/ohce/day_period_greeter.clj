(ns ohce.day-period-greeter)

(defn- greeting [hour]
  (cond
    (and (<= 6 hour) (< hour 12)) "Buenos días"
    (and (<= 12 hour) (< hour 20)) "Buenas tardes"
    :else "Buenas noches"))

(defn select-greeting [hour-fn name]
  (let [greeting (greeting (hour-fn))]
    (str "¡" greeting " " name "!")))