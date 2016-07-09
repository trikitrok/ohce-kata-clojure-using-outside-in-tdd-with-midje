(ns ohce.unit-tests.day-period-greeting-selection-test
  (:require
    [midje.sweet :refer :all]
    [ohce.greet-selectors :refer [select-by-day-period]]))

(unfinished hour-fn)

(facts
  "about hour greeter"

  (fact
    "during the morning"

    (select-by-day-period hour-fn "Koko") => "¡Buenos días Koko!"
    (provided (hour-fn) => 6)

    (select-by-day-period hour-fn "Koko") => "¡Buenos días Koko!"
    (provided (hour-fn) => 8)

    (select-by-day-period hour-fn "Koko") => "¡Buenos días Koko!"
    (provided (hour-fn) => 11))

  (fact
    "during the afternoon"

    (select-by-day-period hour-fn "Koko") => "¡Buenas tardes Koko!"
    (provided (hour-fn) => 12)

    (select-by-day-period hour-fn "Koko") => "¡Buenas tardes Koko!"
    (provided (hour-fn) => 16)

    (select-by-day-period hour-fn "Koko") => "¡Buenas tardes Koko!"
    (provided (hour-fn) => 19))


  (fact
    "during the afternoon"

    (select-by-day-period hour-fn "Koko") => "¡Buenas noches Koko!"
    (provided (hour-fn) => 20)

    (select-by-day-period hour-fn "Koko") => "¡Buenas noches Koko!"
    (provided (hour-fn) => 24)

    (select-by-day-period hour-fn "Koko") => "¡Buenas noches Koko!"
    (provided (hour-fn) => 5)))
