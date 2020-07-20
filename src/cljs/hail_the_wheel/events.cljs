(ns hail-the-wheel.events
  (:require
   [re-frame.core :as re-frame]
   [hail-the-wheel.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(def yes-no-strings ["YES" "NO"])

(re-frame/reg-event-fx
 :spin
 [(re-frame/inject-cofx :yn)]
 (fn [cofx _]
   {:db (assoc (:db cofx) :yn (:yn cofx))}))

(re-frame/reg-cofx
  :yn
  (fn [cofx _]
    (assoc cofx :yn (yes-no-strings (int (rand 2))))))
