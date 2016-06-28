(ns ohce.unit-tests.ohce-test
  (:require
    [midje.sweet :refer :all]
    [ohce.core :refer :all]
    [ohce.notifications :as notifications]))

(defn- register-call [func-keyword an-atom & args]
  (let [args (if (nil? args) :no-args args)
        calls (func-keyword @an-atom)]
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
    (register-call :palindromes-rock notifications)))

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
        (read-input) => ""
        (select-greeting ...username...) => ...greeting...)

      (args-of-call :greet :notifications notifier) => [[...greeting...]]))

  (fact
    "it reverses the user input"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) => "hola")

      (args-of-call :echo :notifications notifier) => [["aloh"]]))

  (fact
    "it reverses the user input if it's not black"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) => "")

      (args-of-call :echo :notifications notifier) => nil))

  (fact
    "it identifies palindromes"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) => "oto")

      (args-of-call :echo :notifications notifier) => [["oto"]]
      (args-of-call :palindromes-rock :notifications notifier) => [:no-args]))
  )