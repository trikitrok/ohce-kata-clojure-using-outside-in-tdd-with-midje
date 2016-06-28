(ns ohce.day-period-greeter)

(defn- greeting [hour]
  (cond
    (and (<= 6 hour) (< hour 12)) "Buenos días"
    (and (<= 12 hour) (< hour 20)) "Buenas tardes"
    :else "Buenas noches"))

(defn- format-greeting [greeting name]
  (str "¡" greeting " " name "!"))

(defn select-greeting [hour-fn name]
  (-> (greeting (hour-fn))
      (format-greeting name)))