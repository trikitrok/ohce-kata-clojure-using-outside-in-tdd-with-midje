(ns ohce.unit-tests.ohce-test
  (:require
    [midje.sweet :refer :all]
    [ohce.core :refer :all]
    [ohce.notifications :as notifications]))

(defn- register-call [func-keyword an-atom & args]
  (let [args (if (nil? args) :no-args args)
        calls (vec (func-keyword @an-atom))]
    (swap! an-atom assoc func-keyword (conj calls args))))

(defn- args-of-call
  [func-keyword atom-keyword protocol-implementation]
  (func-keyword @(atom-keyword protocol-implementation)))

(defrecord FakeNotifier [notifications]
  notifications/Notifier
  (greet [_ greeting]
    (register-call :greet notifications greeting))

  (echo [_ reversed-phrase]
    (register-call :echo notifications reversed-phrase))

  (palindromes-rock [_]
    (register-call :palindromes-rock notifications))

  (bye-user [_ name]
    (register-call :bye-user notifications name)))

(defn fake-notifier []
  (->FakeNotifier (atom {})))

(unfinished select-greeting)
(unfinished read-input)

(facts
  "about ohce"

  (fact
    "it greets the user"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant
      (provided
        (read-input) => "Stop!"
        (select-greeting ...username...) => ...greeting...)

      (args-of-call :greet :notifications notifier) => [[...greeting...]]))

  (fact
    "it reverses the user inputs"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["hola" "lolo" "Stop!"])

      (args-of-call :echo :notifications notifier) => [["aloh"] ["olol"]]))

  (fact
    "it reverses the user inputs that are not blank"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["" "Stop!"])

      (args-of-call :echo :notifications notifier) => nil))

  (fact
    "it identifies palindromes"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["oto" "ana" "Stop!"])

      (args-of-call :echo :notifications notifier) => [["oto"] ["ana"]]
      (args-of-call :palindromes-rock :notifications notifier) => [:no-args :no-args]))

  (fact
    "it knows when to stop"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) =streams=> ["Stop!"])

      (args-of-call :bye-user :notifications notifier) => [[...username...]])))