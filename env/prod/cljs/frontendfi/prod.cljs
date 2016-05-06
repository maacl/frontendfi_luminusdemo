(ns frontendfi.app
  (:require [frontendfi.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
