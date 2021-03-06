package org.easymock.cdi.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;

@Interceptor
@InterceptorTwoBinding
public class InterceptorTwo {

    @Inject
    private Logger logger;

    @Inject
    private InterceptorTwoFacade interceptorTwoFacade;

    @AroundInvoke
    public Object aroundInvoke(final InvocationContext ctx) throws Exception {
        logger.info(getClass().getName() + " interceptor running.");
        interceptorTwoFacade.executedFromInterceptorTwo();
        return ctx.proceed();
    }
}
