(ns ohce.notifications)

(defprotocol Notifier
  (greet [this greeting])
  (echo [this reversed-phrase])
  (palindromes-rock [this])
  (bye-user [this name]))


