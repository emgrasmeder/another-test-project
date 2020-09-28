(ns game.other-init
  (:require [arcadia.core :refer :all]
            [arcadia.linear :as l]
            [arcadia.introspection :as i]
            [game.movement :refer [move!]]
            [game.defaults :refer [init-fps!]]
            [game.game-objects :refer [skybox]]))

;; To use this file:
;; 1. Push "Play" in Unity 3d
;; 2. start miracle mode
;; 3. miracle-load-file
;; 4. save the file and watch it go in unity


(defonce holder (create-primitive :sphere "Beholder"))
;; for more information on the hydration process see:
;; https://gist.github.com/Saikyun/0be79a504149a6970c590dd49194105a#file-hydration-clj-L69-L86

(defn clear-scene!
  [go]
  (doseq [c (children go)]
    (destroy c)))

(hook+ (object-named "Main Camera")
       :start
       :set-fps
       #'init-fps!)



(defn init!
  [& _]
  (let [holder (object-named "Beholder")
        c1 (create-primitive :cube "fast one")
        c2 (create-primitive :cube "show one")]
    (clear-scene! holder)

    (child+ holder c1)
    (child+ holder c2)
    (child+ holder skybox)

    (set! (.. c1 transform position)
          (l/v3 3 1 0))

    (set! (.. c2 transform position)
          (l/v3 -3 0 0))

    (hook+ c1 :update :move-fast #'move!)
    (hook+ c2 :update :move-slow #'move!)))


(init!)
