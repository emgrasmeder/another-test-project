(ns game.game-objects
  (:require [arcadia.core :refer :all]
            [arcadia.linear :as l]
            [arcadia.introspection :as i]
            [game.movement :refer [move!]]
            [game.defaults :refer [init-fps!]]))

(def skybox (create-primitive :cube "skybox"))
(set! (.. skybox transform position)
          (l/v3 4 4 0))
