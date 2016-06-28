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
             assoc :greet (conj calls greeting)))))

(defn fake-notifier []
  (->FakeNotifier (atom {})))

(unfinished select-greeting)
(unfinished read-input)

(facts
  "about ohce"

  (fact
    "it greets the user"

    (let [greeting "Buenos días Pedro"
          notifier (fake-notifier)]

      (ohce select-greeting notifier read-input "Pedro") => irrelevant
      (provided
        (select-greeting "Pedro") => greeting)

      (:greet @(:notifications notifier)) => [greeting]))

  )