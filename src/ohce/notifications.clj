(ns ohce.notifications)

(defprotocol Notifier
  (greet [this greeting])
  (echo [this reversed-phrase]))
