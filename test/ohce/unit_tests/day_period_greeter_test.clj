(ns ohce.unit-tests.day-period-greeter-test
  (:require
    [midje.sweet :refer :all]
    [ohce.day-period-greeter :refer [select-greeting]]))

(unfinished hour-fn)

(facts

  "about hour greeter"

  (fact
    "during the morning"

    (select-greeting hour-fn "Koko") => "¡Buenos días Koko!"
    (provided (hour-fn) => 6)

    (select-greeting hour-fn "Koko") => "¡Buenos días Koko!"
    (provided (hour-fn) => 8)

    (select-greeting hour-fn "Koko") => "¡Buenos días Koko!"
    (provided (hour-fn) => 11))

  (fact
    "during the afternoon"

    (select-greeting hour-fn "Koko") => "¡Buenas tardes Koko!"
    (provided (hour-fn) => 12)

    (select-greeting hour-fn "Koko") => "¡Buenas tardes Koko!"
    (provided (hour-fn) => 16)

    (select-greeting hour-fn "Koko") => "¡Buenas tardes Koko!"
    (provided (hour-fn) => 19))


  (fact
    "during the afternoon"

    (select-greeting hour-fn "Koko") => "¡Buenas noches Koko!"
    (provided (hour-fn) => 20)

    (select-greeting hour-fn "Koko") => "¡Buenas noches Koko!"
    (provided (hour-fn) => 24)

    (select-greeting hour-fn "Koko") => "¡Buenas noches Koko!"
    (provided (hour-fn) => 5)))
