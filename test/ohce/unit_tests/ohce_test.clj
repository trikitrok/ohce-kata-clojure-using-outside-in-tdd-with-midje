(ns ohce.unit-tests.ohce-test
  (:require
    [midje.sweet :refer :all]
    [ohce.ohce :refer :all]
    [ohce.notifications :as notifications]
    [midje.open-protocols :refer [defrecord-openly]]))

(unfinished select-greeting)

(unfinished read-input)

(unfinished greet)
(unfinished echo)
(unfinished palindromes-rock)
(unfinished bye-user)

(defrecord-openly FakeNotifier []
  notifications/Notifier
  (greet [this greeting])
  (echo [this reversed-phrase])
  (palindromes-rock [this])
  (bye-user [this name]))

(facts
  "about ohce"

  (fact
    "it greets the user"

    (let [notifier (->FakeNotifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (read-input) => "Stop!"

        (select-greeting ...username...) => ...greeting...

        (greet notifier ...greeting...) => irrelevant :times 1)))

  (fact
    "it reverses the user inputs"

    (let [notifier (->FakeNotifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant

        (read-input) =streams=> ["hola" "lolo" "Stop!"]

        (echo notifier "aloh") => irrelevant :times 1

        (echo notifier "olol") => irrelevant :times 1)))

  (fact
    "it ignores inputs that are blank"

    (let [notifier (->FakeNotifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant

        (read-input) =streams=> ["memo" "" "moko" "Stop!"]

        (echo notifier "omem") => irrelevant :times 1

        (echo notifier "okom") => irrelevant :times 1)))

  (fact
    "it identifies palindromes"

    (let [notifier (->FakeNotifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant

        (read-input) =streams=> ["oto" "ana" "Stop!"]

        (echo notifier "oto") => irrelevant :times 1

        (echo notifier "ana") => irrelevant :times 1

        (palindromes-rock notifier) => irrelevant :times 2)))

  (fact
    "it knows when to stop"

    (let [notifier (->FakeNotifier)
          stop-word "Stop!"]

      (ohce select-greeting notifier read-input stop-word ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant

        (read-input) =streams=> ["Stop!"]

        (bye-user notifier ...username...) => irrelevant :times 1))))
