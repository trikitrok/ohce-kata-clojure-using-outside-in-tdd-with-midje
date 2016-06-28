(ns ohce.clock
  (:import (java.util Calendar)))

(defn hour []
  (.get (Calendar/getInstance) Calendar/HOUR_OF_DAY))


