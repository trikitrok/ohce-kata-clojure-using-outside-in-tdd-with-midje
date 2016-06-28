(ns ohce.unit-tests.ohce-test
  (:require
    [midje.sweet :refer :all]
    [ohce.core :refer :all]
    [ohce.test-helpers :as test-helpers]))

(unfinished select-greeting)
(unfinished read-input)

(facts
  "about ohce"

  (fact
    "it greets the user"

    (let [notifier (test-helpers/fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant
      (provided
        (read-input) => "Stop!"
        (select-greeting ...username...) => ...greeting...)

      (test-helpers/args-of-call
        :greet :notifications notifier) => [[...greeting...]]))

  (fact
    "it reverses the user inputs"

    (let [notifier (test-helpers/fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["hola" "lolo" "Stop!"])

      (test-helpers/args-of-call
        :echo :notifications notifier) => [["aloh"] ["olol"]]))

  (fact
    "it reverses the user inputs that are not blank"

    (let [notifier (test-helpers/fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["" "Stop!"])

      (test-helpers/args-of-call
        :echo :notifications notifier) => nil))

  (fact
    "it identifies palindromes"

    (let [notifier (test-helpers/fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["oto" "ana" "Stop!"])

      (test-helpers/args-of-call
        :echo :notifications notifier) => [["oto"] ["ana"]]
      (test-helpers/args-of-call
        :palindromes-rock :notifications notifier) => [:no-args :no-args]))

  (fact
    "it knows when to stop"

    (let [notifier (test-helpers/fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["Stop!"])

      (test-helpers/args-of-call
        :bye-user :notifications notifier) => [[...username...]])))
