(ns ohce.acceptance-test
  (:require
    [midje.sweet :refer :all]
    [ohce.ohce :refer :all]
    [ohce.greet-selectors :refer [select-by-day-period]]
    [ohce.notifications :refer [console-notifier]]
    [ohce.test-helpers :as helpers]))

(unfinished read-input)
(unfinished hour-fn)

(let [notifications-config {:bye-word "Adios"
                            :celebration "¡Bonita palabra!"}]
  (facts
  "about running ohce"

  (fact
    "during the morning"

    (let [stop-word "Stop!"
          any-hour-during-morning 9
          notifier (console-notifier notifications-config)
          select-greeting (fn [name] (select-by-day-period hour-fn name))
          ohce (partial ohce select-greeting notifier #(read-input) stop-word)]

      (helpers/output-lines
        ohce "Pedro") => ["¡Buenos días Pedro!"
                          "aloh"
                          "oto"
                          "¡Bonita palabra!"
                          "pots"
                          "Adios Pedro"]
      (provided
        (hour-fn) => any-hour-during-morning
        (read-input) =streams=> ["hola" "oto" "stop" "Stop!"])))

  (fact
    "during the afternoon"

    (let [stop-word "Stop!"
          any-hour-during-afternoon 16
          notifier (console-notifier notifications-config)
          select-greeting (fn [name] (select-by-day-period hour-fn name))
          ohce (partial ohce select-greeting notifier #(read-input) stop-word)]

      (helpers/output-lines
        ohce "Lolo") => ["¡Buenas tardes Lolo!"
                         "opip"
                         "Adios Lolo"]
      (provided
        (hour-fn) => any-hour-during-afternoon
        (read-input) =streams=> ["pipo" "Stop!"])))

  (fact
    "during the afternoon"

    (let [stop-word "Stop!"
          any-hour-during-night 1
          notifier (console-notifier notifications-config)
          select-greeting (fn [name] (select-by-day-period hour-fn name))
          ohce (partial ohce select-greeting notifier #(read-input) stop-word)]

      (helpers/output-lines
        ohce "Juan") => ["¡Buenas noches Juan!"
                         "oko"
                         "¡Bonita palabra!"
                         "Adios Juan"]
      (provided
        (hour-fn) => any-hour-during-night
        (read-input) =streams=> ["oko" "Stop!"])))))
