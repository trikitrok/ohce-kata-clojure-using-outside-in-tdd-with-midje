(ns ohce.acceptance-test
  (:require [midje.sweet :refer :all]
            [ohce.core :refer :all]))

(unfinished hour-fn)
(unfinished read-input)

(future-facts
  "about running ohce"

  (fact
    "during the morning"

    (clojure.string/split
      (with-out-str
        (ohce hour-fn read-input "Pedro"))
      #"\n") => ["¡Buenos días Pedro!"
                 "aloh"
                 "oto"
                 "¡Bonita palabra!"
                 "pots"
                 "Adios Pedro"]
    (provided
      (hour-fn) => 8
      (read-input) =streams=> ["hola" "oto" "stop" "Stop!"])))