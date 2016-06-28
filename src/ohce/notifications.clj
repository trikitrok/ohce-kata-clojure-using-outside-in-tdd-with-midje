(ns ohce.notifications)

(defprotocol Notifier
  (greet [this greeting]))
