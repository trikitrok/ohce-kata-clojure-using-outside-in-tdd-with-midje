(ns ohce.notifications)

(defprotocol Notifier
  (greet [this greeting])
  (echo [this reversed-phrase])
  (palindromes-rock [this])
  (bye-user [this name]))

(defrecord ConsoleNotifier []
  Notifier
  (greet [_ greeting]
    (println greeting))

  (echo [_ reversed-phrase]
    (println reversed-phrase))

  (palindromes-rock [_]
    (println "¡Bonita palabra!"))

  (bye-user [_ name]
    (println (str "Adios " name))))

(defn console-notifier []
  (->ConsoleNotifier))



