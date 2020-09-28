(ns game.movement
  (:require [arcadia.core :refer :all]
            [arcadia.linear :as l]
            [arcadia.introspection :as i]))


(defn move!
  [go k]
  (let [old-pos (.. go transform position)
        velocity
        (cond
          (= k :move-fast) (l/v3 0.05 0 0)
          (= k :move-slow) (l/v3 0.01 0 0)
          :default (log (str "No speed set for" k)))]
    (set! (.. go transform position)
          (l/v3+ old-pos velocity))))

