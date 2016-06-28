(ns ohce.notifications)

(defprotocol Notifier
  (greet [this greeting])
  (echo [this reversed-phrase])
  (palindromes-rock [this])
  (bye-user [this name]))

(defrecord ConsoleNotifier []
  Notifier
  (greet [_ greeting]
    (println greeting)))

(defn console-notifier []
  (->ConsoleNotifier))



