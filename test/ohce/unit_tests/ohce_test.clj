(ns ohce.unit-tests.ohce-test
  (:require
    [midje.sweet :refer :all]
    [ohce.ohce :refer :all]
    [ohce.test-helpers :as helpers]))

(unfinished select-greeting)
(unfinished read-input)

(facts
  "about ohce"

  (fact
    "it greets the user"

    (let [notifier (helpers/fake-notifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant
      (provided
        (read-input) => "Stop!"
        (select-greeting ...username...) => ...greeting...)

      (helpers/args-of-call
        :greet :notifications notifier) => [[...greeting...]]))

  (fact
    "it reverses the user inputs"

    (let [notifier (helpers/fake-notifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["hola" "lolo" "Stop!"])

      (helpers/args-of-call
        :echo :notifications notifier) => [["aloh"] ["olol"]]))

  (fact
    "it reverses the user inputs that are not blank"

    (let [notifier (helpers/fake-notifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["" "Stop!"])

      (helpers/args-of-call
        :echo :notifications notifier) => nil))

  (fact
    "it identifies palindromes"

    (let [notifier (helpers/fake-notifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["oto" "ana" "Stop!"])

      (helpers/args-of-call
        :echo :notifications notifier) => [["oto"] ["ana"]]
      (helpers/args-of-call
        :palindromes-rock :notifications notifier) => [:no-args :no-args]))

  (fact
    "it knows when to stop"

    (let [notifier (helpers/fake-notifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["Stop!"])

      (helpers/args-of-call
        :bye-user :notifications notifier) => [[...username...]])))
