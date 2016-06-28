(ns ohce.acceptance-test
  (:require [midje.sweet :refer :all]
            [ohce.core :refer :all]
            [ohce.day-period-greeter :refer [select-greeting]]
            [ohce.notifications :refer [console-notifier]]))

(unfinished read-input)
(unfinished hour-fn)

(facts
  "about running ohce"

  (fact
    "during the morning"

    (let [any-hour-during-morning 9
          notifier (console-notifier {:bye-word "Adios" :celebration "¡Bonita palabra!"})
          select-greeting (fn [name] (select-greeting hour-fn name))]
      (clojure.string/split
        (with-out-str (ohce select-greeting notifier read-input "Pedro"))
        #"\n") => ["¡Buenos días Pedro!"
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

    (let [any-hour-during-afternoon 16
          notifier (console-notifier {:bye-word "Adios" :celebration "¡Bonita palabra!"})
          select-greeting (fn [name] (select-greeting hour-fn name))]
      (clojure.string/split
        (with-out-str (ohce select-greeting notifier read-input "Lolo"))
        #"\n") => ["¡Buenas tardes Lolo!"
                   "opip"
                   "Adios Lolo"]
      (provided
        (hour-fn) => any-hour-during-afternoon
        (read-input) =streams=> ["pipo" "Stop!"])))

  (fact
    "during the afternoon"

    (let [any-hour-during-night 1
          notifier (console-notifier {:bye-word "Adios" :celebration "¡Bonita palabra!"})
          select-greeting (fn [name] (select-greeting hour-fn name))]
      (clojure.string/split
        (with-out-str (ohce select-greeting notifier read-input "Juan"))
        #"\n") => ["¡Buenas noches Juan!"
                   "oko"
                   "¡Bonita palabra!"
                   "Adios Juan"]
      (provided
        (hour-fn) => any-hour-during-night
        (read-input) =streams=> ["oko" "Stop!"]))))