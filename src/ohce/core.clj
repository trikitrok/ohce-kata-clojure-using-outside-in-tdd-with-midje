(ns ohce.core
  (:require
    [ohce.ohce :refer :all]
    [ohce.clock :as clock]
    [ohce.notifications :refer [console-notifier]]
    [ohce.greet-selectors :as greet-selectors]
    [ohce.user-input :as user-input]))

(defn -main [& args]
  (let [select-greeting (partial greet-selectors/select-by-day-period clock/hour)
        notifier (console-notifier {:bye-word "Adios" :celebration "¡Bonita palabra!"})
        ohce (partial ohce select-greeting notifier user-input/read "Stop!")]
    (ohce (first args))))
