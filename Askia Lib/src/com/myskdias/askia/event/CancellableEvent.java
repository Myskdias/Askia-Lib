package com.myskdias.askia.event;

public interface CancellableEvent extends Event {
	public boolean isCancelled();
	public void setCancelled(boolean cancelled);
}
