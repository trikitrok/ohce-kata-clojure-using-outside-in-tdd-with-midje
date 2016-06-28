(ns ohce.unit-tests.console-notifications-test
  (:require
    [midje.sweet :refer :all]
    [ohce.test-helpers :as test-helpers]
    [ohce.notifications :refer [console-notifier greet bye-user echo palindromes-rock]]))

(facts
  "about console notifications"

  (let [notifier (console-notifier {:bye-word "Adios" :celebration "¡Bonita palabra!"})]

    (fact
      "greeting user"
      (test-helpers/output-lines
        greet notifier "greeting") => ["greeting"])

    (fact
      "greeting user"
      (test-helpers/output-lines
        bye-user notifier "Juan") => ["Adios Juan"])

    (fact
      "echoing word"
      (test-helpers/output-lines
        echo notifier "moko") => ["moko"])

    (fact
      "celebrating palindromes"
      (test-helpers/output-lines
        palindromes-rock notifier) => ["¡Bonita palabra!"])))
