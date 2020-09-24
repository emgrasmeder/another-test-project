(ns game.other-init
  (:require [arcadia.core :refer :all]
            [arcadia.linear :as l]
            [arcadia.introspection :as i]
            [game.movement :refer [move!]])
  (:import
   [UnityEngine Application
    QualitySettings]))



;; Don't burn my computer
(defn init-fps!
  [& _]
  (set! (.. QualitySettings vSyncCount) 0)
  (set! (.. Application targetFrameRate) 15))

(init-fps!)

(defonce holder (create-primitive :sphere "Beholder"))


(hook+ (object-named "Main Camera")
       :start
       :set-fps
       #'init-fps!)

(defn clear-scene!
  [go]
  (doseq [c (children go)]
    (destroy c)))



(defn init!
  [& _]
  (let [holder (object-named "Beholder")
        c1 (create-primitive :cube)
        c2 (create-primitive :cube)]
    (clear-scene! holder)

    (child+ holder c1)
    (set! (.. c1 transform position)
          (l/v3 3 1 0))

    (child+ holder c2)
    (set! (.. c2 transform position)
          (l/v3 -3 0 0))

    (hook+ c1 :update :move-fast #'move!)
    (hook+ c2 :update :move-slow #'move!)))


(init!)

