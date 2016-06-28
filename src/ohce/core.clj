(ns ohce.core
  (:require
    [ohce.ohce :refer :all]
    [ohce.clock :as clock]
    [ohce.notifications :refer [console-notifier]]
    [ohce.day-period-greeter :as greeter]))

(defn -main [& args]
  (let [select-greeting (partial greeter/select-greeting clock/hour)
        notifier (console-notifier {:bye-word "Adios" :celebration "¡Bonita palabra!"})
        ohce (partial ohce select-greeting notifier read-line "Stop!")]
    (ohce (first args))))
