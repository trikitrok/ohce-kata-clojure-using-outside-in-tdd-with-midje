(ns ohce.test-helpers
  (:require
    [ohce.notifications :as notifications]))

(defn- register-call [func-keyword an-atom & args]
  (let [args (if (nil? args) :no-args args)
        calls (vec (func-keyword @an-atom))]
    (swap! an-atom assoc func-keyword (conj calls args))))

(defn output-lines [f & args]
  (clojure.string/split (with-out-str (apply f args)) #"\n"))

(defn args-of-call
  [func-keyword atom-keyword protocol-implementation]
  (func-keyword @(atom-keyword protocol-implementation)))

(defrecord FakeNotifier [notifications]
  notifications/Notifier
  (greet [_ greeting]
    (register-call :greet notifications greeting))

  (echo [_ reversed-phrase]
    (register-call :echo notifications reversed-phrase))

  (palindromes-rock [_]
    (register-call :palindromes-rock notifications))

  (bye-user [_ name]
    (register-call :bye-user notifications name)))

(defn fake-notifier []
  (->FakeNotifier (atom {})))
