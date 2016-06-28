(ns ohce.unit-tests.ohce-test
  (:require
    [midje.sweet :refer :all]
    [ohce.core :refer :all]
    [ohce.notifications :as notifications]))

(defrecord FakeNotifier [notifications]
  notifications/Notifier
  (greet [_ greeting]
    (let [calls (:greet @notifications)]
      (swap! notifications
             assoc :greet (conj calls greeting))))

  (echo [_ reversed-phrase]
    (let [calls (:echo @notifications)]
      (swap! notifications
             assoc :echo (conj calls reversed-phrase)))))

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

      (:greet @(:notifications notifier)) => [...greeting...]))

  (fact
    "it reverses the user input"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) => "hola")

      (:echo @(:notifications notifier)) => ["aloh"]))

  (fact
    "it reverses the user input if it's not black"

    (let [notifier (fake-notifier)]

      (ohce select-greeting notifier read-input ...username...) => irrelevant

      (provided
        (select-greeting ...username...) => irrelevant
        (read-input) => "")

      (:echo @(:notifications notifier)) => nil))
  )