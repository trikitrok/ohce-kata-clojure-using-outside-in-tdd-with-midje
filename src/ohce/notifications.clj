(ns ohce.notifications)

(defprotocol Notifier
  (greet [this greeting])
  (echo [this reversed-phrase])
  (palindromes-rock [this])
  (bye-user [this name]))

(defrecord ConsoleNotifier [config]
  Notifier
  (greet [_ greeting]
    (println greeting))

  (echo [_ reversed-phrase]
    (println reversed-phrase))

  (palindromes-rock [this]
    (println (get-in this [:config :celebration])))

  (bye-user [this name]
    (println
      (str (get-in this [:config :bye-word]) " " name))))

(defn console-notifier [config]
  (->ConsoleNotifier config))
