(ns game.defaults
  (:require [arcadia.core :refer :all])
  (:import
   [UnityEngine Application
    QualitySettings]))


;; Don't burn my computer
(defn init-fps!
  [& _]
  (set! (.. QualitySettings vSyncCount) 0)
  (set! (.. Application targetFrameRate) 15))
