package jll.security;

import org.springframework.security.core.AuthenticationException;

public class BadAnswerException extends AuthenticationException {

	private static final long serialVersionUID = -3333012976129153127L;

	public BadAnswerException(String msg) {
		super(msg);
	}

}
